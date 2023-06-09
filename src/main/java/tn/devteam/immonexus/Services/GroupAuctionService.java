package tn.devteam.immonexus.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.devteam.immonexus.Interfaces.IGroupAuctionService;
import tn.devteam.immonexus.Repository.GroupAuctionRepository;

@Service
@Slf4j
public class GroupAuctionService implements IGroupAuctionService {
    @Autowired
    GroupAuctionRepository groupAuctionRepository;
}
