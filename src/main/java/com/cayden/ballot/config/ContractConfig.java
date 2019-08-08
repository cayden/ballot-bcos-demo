/*
 *       Copyright© (2018-2019) WeBank Co., Ltd.
 *
 *       This file is part of weidentity-java-sdk.
 *
 *       weidentity-java-sdk is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       weidentity-java-sdk is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with weidentity-java-sdk.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.cayden.ballot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * contract address config.
 *
 * @author tonychen 2018.9.29
 */
@Component("ContractConfig")
@Data
public class ContractConfig {
    /**
     * The ballot  Contract address.
     */
    @Value("${ballot.contractaddress}")
    private String ballotAddress;

    @Value("${voting.contractaddress}")
    private String votingAddress;

    public String getBallotAddress() {
        return ballotAddress;
    }

    public void setBallotAddress(String ballotAddress) {
        this.ballotAddress = ballotAddress;
    }

    public String getVotingAddress() {
        return votingAddress;
    }

    public void setVotingAddress(String votingAddress) {
        this.votingAddress = votingAddress;
    }
}
