package com.wsdev.Client.controllers;

import com.wsdev.Client.dto.ClientDTO;
import com.wsdev.Client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        ClientDTO dto = service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<ClientDTO> dto = service.findAll(pageable);
        return dto;
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO dto) {
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping(value = "/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO dto) {
        dto = service.update(id, dto);
        return dto;
    }

<<<<<<< HEAD
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
       service.delete(id);
    }

=======
>>>>>>> e0906036478acc4fa9b43ce88b79ac0bd4e5bbef
}
