package com.cayden.ballot.controller;

import com.cayden.ballot.contract.Proposal;
import com.cayden.ballot.service.BallotService;
import com.cayden.ballot.service.VotingService;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by caydencui on 2019/6/4.
 */
@RestController
@RequestMapping("/ballot")
public class BallotController {

    private static final Logger logger = LoggerFactory.getLogger(BallotController.class);

    @Autowired
    private BallotService ballotService;


    @Autowired
    private VotingService votingService;

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
    @PostMapping("/deploy")
    public String deploy(@RequestBody List<String> list){
        logger.info("list: {}", list);
        try {
            return votingService.deploy(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "参数错误!";
    }

    @PostMapping("/votefor")
    public TransactionReceipt voteForCandidate(String candidate){
        logger.info("candidate: {}", candidate);
        try {
            return votingService.voteForCandidate(candidate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/totalVote")
    public BigInteger totalVotesFor(String candidate){
        logger.info("candidate: {}", candidate);
        try {
            return votingService.totalVotesFor(candidate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return BigInteger.valueOf(0);
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
