package com.wsdev.Client.services;

import com.wsdev.Client.dto.ClientDTO;
import com.wsdev.Client.entities.Client;
import com.wsdev.Client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Propagation;
=======
>>>>>>> e0906036478acc4fa9b43ce88b79ac0bd4e5bbef
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> result = repository.findById(id);
        Client client = result.get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToENtity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = repository.getReferenceById(id);
        copyDtoToENtity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

<<<<<<< HEAD
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        repository.deleteById(id);
    }

=======
>>>>>>> e0906036478acc4fa9b43ce88b79ac0bd4e5bbef
    private void copyDtoToENtity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
