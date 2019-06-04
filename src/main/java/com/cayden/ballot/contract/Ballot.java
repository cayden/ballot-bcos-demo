package com.cayden.ballot.contract;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Ballot extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051610e08380380610e08833981018060405281019080805182019291905050506000336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000181905550600090505b81518110156101735760026040805190810160405280848481518110151561010657fe5b90602001906020020151600019168152602001600081525090806001815401808255809150509060018203906000526020600020906002020160009091929091909150600082015181600001906000191690556020820151816001015550505080806001019150506100e2565b5050610c84806101846000396000f30060806040526004361061008e576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630121b93f14610093578063013cf08b146100c05780632e4176cf146101105780635c19a95c14610167578063609ff1bd146101aa5780639e7b8d61146101d5578063a3ec138d14610218578063e2ba53f0146102b4575b600080fd5b34801561009f57600080fd5b506100be600480360381019080803590602001909291905050506102e7565b005b3480156100cc57600080fd5b506100eb6004803603810190808035906020019092919050505061048a565b6040518083600019166000191681526020018281526020019250505060405180910390f35b34801561011c57600080fd5b506101256104bd565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561017357600080fd5b506101a8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104e2565b005b3480156101b657600080fd5b506101bf610907565b6040518082815260200191505060405180910390f35b3480156101e157600080fd5b50610216600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610982565b005b34801561022457600080fd5b50610259600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bcc565b60405180858152602001841515151581526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200194505050505060405180910390f35b3480156102c057600080fd5b506102c9610c29565b60405180826000191660001916815260200191505060405180910390f35b6000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020905060008160000154141515156103a7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260148152602001807f486173206e6f20726967687420746f20766f746500000000000000000000000081525060200191505060405180910390fd5b8060010160009054906101000a900460ff1615151561042e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600e8152602001807f416c726561647920766f7465642e00000000000000000000000000000000000081525060200191505060405180910390fd5b60018160010160006101000a81548160ff021916908315150217905550818160020181905550806000015460028381548110151561046857fe5b9060005260206000209060020201600101600082825401925050819055505050565b60028181548110151561049957fe5b90600052602060002090600202016000915090508060000154908060010154905082565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508160010160009054906101000a900460ff161515156105ad576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f596f7520616c726561647920766f7465642e000000000000000000000000000081525060200191505060405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614151515610651576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f53656c662d64656c65676174696f6e20697320646973616c6c6f7765642e000081525060200191505060405180910390fd5b5b600073ffffffffffffffffffffffffffffffffffffffff16600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156107f857600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1692503373ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141515156107f3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f466f756e64206c6f6f7020696e2064656c65676174696f6e2e0000000000000081525060200191505060405180910390fd5b610652565b60018260010160006101000a81548160ff021916908315150217905550828260010160016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060010160009054906101000a900460ff16156108eb578160000154600282600201548154811015156108c857fe5b906000526020600020906002020160010160008282540192505081905550610902565b816000015481600001600082825401925050819055505b505050565b6000806000809150600090505b60028054905081101561097d578160028281548110151561093157fe5b90600052602060002090600202016001015411156109705760028181548110151561095857fe5b90600052602060002090600202016001015491508092505b8080600101915050610914565b505090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a6c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001807f4f6e6c79206368616972706572736f6e2063616e20676976652072696768742081526020017f746f20766f74652e00000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160009054906101000a900460ff16151515610b31576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f54686520766f74657220616c726561647920766f7465642e000000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000154141515610b8257600080fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018190555050565b60016020528060005260406000206000915090508060000154908060010160009054906101000a900460ff16908060010160019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020154905084565b60006002610c35610907565b815481101515610c4157fe5b9060005260206000209060020201600001549050905600a165627a7a72305820c5da00dfdfeb11d59e4dde0736a27e7fadb5111cd1d25b2564b694805607bd040029";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_PROPOSALS = "proposals";

    public static final String FUNC_CHAIRPERSON = "chairperson";

    public static final String FUNC_DELEGATE = "delegate";

    public static final String FUNC_WINNINGPROPOSAL = "winningProposal";

    public static final String FUNC_GIVERIGHTTOVOTE = "giveRightToVote";

    public static final String FUNC_VOTERS = "voters";

    public static final String FUNC_WINNERNAME = "winnerName";

    @Deprecated
    protected Ballot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ballot(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger proposal) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new Uint256(proposal)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void vote(BigInteger proposal, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new Uint256(proposal)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<Tuple2<byte[], BigInteger>> proposals(BigInteger param0) {
        final Function function = new Function(FUNC_PROPOSALS,
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<byte[], BigInteger>>(
                new Callable<Tuple2<byte[], BigInteger>>() {
                    @Override
                    public Tuple2<byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> chairperson() {
        final Function function = new Function(FUNC_CHAIRPERSON,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> delegate(String to) {
        final Function function = new Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new Address(to)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void delegate(String to, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new Address(to)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<BigInteger> winningProposal() {
        final Function function = new Function(FUNC_WINNINGPROPOSAL,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> giveRightToVote(String voter) {
        final Function function = new Function(
                FUNC_GIVERIGHTTOVOTE, 
                Arrays.<Type>asList(new Address(voter)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void giveRightToVote(String voter, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GIVERIGHTTOVOTE, 
                Arrays.<Type>asList(new Address(voter)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>> voters(String param0) {
        final Function function = new Function(FUNC_VOTERS,
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>>(
                new Callable<Tuple4<BigInteger, Boolean, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, Boolean, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, Boolean, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<byte[]> winnerName() {
        final Function function = new Function(FUNC_WINNERNAME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ballot(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ballot(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(proposalNames, Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(proposalNames, Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ballot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(proposalNames, Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(proposalNames, Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
