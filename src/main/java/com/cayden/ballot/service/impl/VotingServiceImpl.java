package com.cayden.ballot.service.impl;

import com.cayden.ballot.config.ContractConfig;
import com.cayden.ballot.constant.WeIdConstant;
import com.cayden.ballot.contract.Ballot;
import com.cayden.ballot.contract.Voting;
import com.cayden.ballot.service.BaseService;
import com.cayden.ballot.service.VotingService;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caydencui on 2019/6/5.
 */
@Service
@Component
public class VotingServiceImpl extends BaseService implements VotingService {

    private static final Logger logger = LoggerFactory.getLogger(BallotServiceImpl.class);

    private static Voting voting;

    private static String votingAddress;

    public VotingServiceImpl() {
        init();
    }


    private static void init() {
        ContractConfig config = context.getBean(ContractConfig.class);
        votingAddress = config.getVotingAddress();
        voting = (Voting) getContractService(votingAddress,
                Voting.class);
    }


    @Override
    public String deploy(List<String> list) throws Exception {
        if (list == null) {
            return null;
        }
        try {
            List<byte[]> bytes = new ArrayList<>();
            for (String name : list) {
                bytes.add(stringtobyte32(name));
            }
            voting = Voting.deploy(
                    web3j,
                    credentials,
                    new StaticGasProvider(WeIdConstant.GAS_PRICE, WeIdConstant.GAS_LIMIT),
                    bytes)
                    .send();

        } catch (Exception e) {
            e.printStackTrace();
            return StringUtils.EMPTY;
        }

        return voting.getContractAddress();
    }

    @Override
    public TransactionReceipt voteForCandidate(String candidateName) throws Exception {

        TransactionReceipt voteReceipt = null;
        if (voting.isValid()) {
            voteReceipt = voting.voteForCandidate(stringtobyte32(candidateName)).sendAsync().get();
            logger.info("voteReceipt: {}", voteReceipt);
        }
        return voteReceipt;
    }


    @Override
    public BigInteger totalVotesFor(String candidateName) throws Exception {
        BigInteger voteReceipt = null;

        if (voting.isValid()) {
            voteReceipt = voting.totalVotesFor(stringtobyte32(candidateName)).sendAsync().get();
            logger.info("totalVotesFor: {}", voteReceipt);
        }
        return voteReceipt;
    }
}
