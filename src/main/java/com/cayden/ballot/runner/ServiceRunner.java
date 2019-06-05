package com.cayden.ballot.runner;

import com.cayden.ballot.service.BaseService;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.protocol.core.methods.request.BcosFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * BCOS2.0暂不支持事件机制
 * Created by caydencui on 2019/6/5.
 */
@Component
public class ServiceRunner extends BaseService implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ServiceRunner.class);

    @Autowired
    private BcosFilter bcosFilter;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        receiveVote();
        logger.info("This will be execute when the project was started!");
    }

    public void receiveVote() {
        Event event = new Event("voteForCandidate",
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {
                }));
        bcosFilter.addSingleTopic(EventEncoder.encode(event));
        logger.info("启动监听 BcosFilter event");

    }
}
