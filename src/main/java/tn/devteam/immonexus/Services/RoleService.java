package tn.devteam.immonexus.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.devteam.immonexus.Interfaces.IRoleService;
import tn.devteam.immonexus.Repository.RoleRepository;

@Service
@Slf4j
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
}
