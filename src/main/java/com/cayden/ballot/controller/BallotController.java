package com.cayden.ballot.controller;

import com.cayden.ballot.contract.Proposal;
import com.cayden.ballot.service.BallotService;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caydencui on 2019/6/4.
 */
@RestController
@RequestMapping("/ballot")
public class BallotController {

    private static final Logger logger = LoggerFactory.getLogger(BallotController.class);

    @Autowired
    private BallotService ballotService;


    @PostMapping("/vote")
    public TransactionReceipt vote(int index) {
        TransactionReceipt transactionReceipt = null;
        try {
            logger.info("index: {}", index);
            transactionReceipt = ballotService.vote(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionReceipt;
    }


    @GetMapping("/winner")
    public Proposal getWinningProposal() {
        Proposal winningProposal=null;
        try {
            winningProposal= ballotService.getWinningProposal();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return winningProposal;
    }
}
