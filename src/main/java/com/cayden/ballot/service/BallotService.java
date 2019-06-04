package com.cayden.ballot.service;

import com.cayden.ballot.contract.Proposal;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

/**
 * Created by caydencui on 2019/6/4.
 */

public interface BallotService {



    public TransactionReceipt vote(int index) throws Exception;


    public Proposal getWinningProposal() throws Exception ;
}
