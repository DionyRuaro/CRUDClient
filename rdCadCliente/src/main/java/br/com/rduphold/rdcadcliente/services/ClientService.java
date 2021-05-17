package br.com.rduphold.rdcadcliente.services;

import br.com.rduphold.rdcadcliente.entities.Client;
import br.com.rduphold.rdcadcliente.entities.ClientDTO;
import br.com.rduphold.rdcadcliente.repositories.ClientRepository;
import br.com.rduphold.rdcadcliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
        Page<Client> list = repo.findAll(pageRequest);

        return list.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repo.findById(id);

        Client cli =obj.orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado!")
        );

        return new ClientDTO(cli);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDto) {
        Client client = new Client();
        copyDtoToEntity(clientDto, client);
        client = repo.save(client);

        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDto) {
        try {
            Client cli = repo.getOne(id);
            copyDtoToEntity(clientDto, cli);
            cli = repo.save(cli);
            return new ClientDTO(cli);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(ClientDTO clientDto, Client client) {
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setBirthDate(clientDto.getBirthDate());
        client.setChildren(clientDto.getChildren());
        client.setIncome(clientDto.getIncome());
    }
}
