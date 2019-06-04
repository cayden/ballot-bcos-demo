package com.cayden.ballot.contract;

import java.math.BigInteger;

/**
 * Created by caydencui on 2019/6/4.
 */

public class Proposal {
    private int proposalNums;

    private String contractAddress;

    private String creator;

    private BigInteger winnerIndex;

    public Proposal() {
    }

    public Proposal(int proposalNums) {
        this.proposalNums = proposalNums;
    }

    public Proposal(int proposalNums, String contractAddress, String creator) {
        this.proposalNums = proposalNums;
        this.contractAddress = contractAddress;
        this.creator = creator;
    }

    public Proposal(int proposalNums, String contractAddress, String creator, BigInteger winnerIndex) {
        this.proposalNums = proposalNums;
        this.contractAddress = contractAddress;
        this.creator = creator;
        this.winnerIndex = winnerIndex;
    }

    public int getProposalNums() {
        return proposalNums;
    }

    public void setProposalNums(int proposalNums) {
        this.proposalNums = proposalNums;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public BigInteger getWinnerIndex() {
        return winnerIndex;
    }

    public void setWinnerIndex(BigInteger winnerIndex) {
        this.winnerIndex = winnerIndex;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "proposalNums=" + proposalNums +
                ", contractAddress='" + contractAddress + '\'' +
                ", creator='" + creator + '\'' +
                ", winnerIndex='" + winnerIndex + '\'' +
                '}';
    }
}
