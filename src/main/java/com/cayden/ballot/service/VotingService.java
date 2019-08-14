package com.cayden.ballot.service;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by caydencui on 2019/6/5.
 */

public interface VotingService {
    /**
     * 部署合约
     * @param list 初始化候选人名单
     * @return
     * @throws Exception
     */
    public String deploy(List<String> list) throws Exception;

    /**
     * 为某个候选人投票
     * @param candidateName 候选人
     * @return
     * @throws Exception
     */
    public TransactionReceipt voteForCandidate(String candidateName) throws Exception;

    /**
     * 查询某个候选人的总票数
     * @param candidateName 候选人
     * @return
     * @throws Exception
     */
    public BigInteger totalVotesFor(String candidateName) throws Exception;

}
