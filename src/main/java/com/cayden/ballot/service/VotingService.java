package com.cayden.ballot.service;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by caydencui on 2019/6/5.
 */

public interface VotingService {

    public String deploy(List<String> list) throws Exception;


    public TransactionReceipt voteForCandidate(String candidateName) throws Exception;

    public BigInteger totalVotesFor(String candidateName) throws Exception;

}
