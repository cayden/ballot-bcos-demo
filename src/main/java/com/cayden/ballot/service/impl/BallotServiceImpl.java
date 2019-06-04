package com.cayden.ballot.service.impl;

import com.cayden.ballot.config.ContractConfig;
import com.cayden.ballot.constant.WeIdConstant;
import com.cayden.ballot.contract.Ballot;
import com.cayden.ballot.contract.Proposal;
import com.cayden.ballot.service.BallotService;
import com.cayden.ballot.service.BaseService;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by caydencui on 2019/6/4.
 */
@Service
@Component
public class BallotServiceImpl extends BaseService implements BallotService {
    private static final Logger logger = LoggerFactory.getLogger(BallotServiceImpl.class);

    private static Ballot ballot;

    private static String ballotAddress;

    public BallotServiceImpl() {
        init();
    }



    private static void init() {
        ContractConfig config = context.getBean(ContractConfig.class);
        ballotAddress = config.getBallotAddress();
        ballot = (Ballot) getContractService(ballotAddress,
                Ballot.class);
    }


    @Override
    public TransactionReceipt vote(int index) throws Exception {
        TransactionReceipt voteReceipt = null;

        if (ballot.isValid()) {
            voteReceipt = ballot.vote(BigInteger.valueOf(index)).sendAsync().get();
            logger.info("voteReceipt: {}", voteReceipt);
        }
        return voteReceipt;
    }


    @Override
    public Proposal getWinningProposal() throws Exception {
        BigInteger proposalIndex = null;
         Proposal proposal=new Proposal();
        if (ballot.isValid()) {
            proposalIndex = ballot.winningProposal().sendAsync().get();
            logger.info("proposalIndex: {}", proposalIndex);

            byte[] bytes = ballot.winnerName().sendAsync().get();
            String name = new String(bytes);
            logger.info("name: {}", name);
        }
        proposal.setWinnerIndex(proposalIndex);
        return proposal;
    }
}
