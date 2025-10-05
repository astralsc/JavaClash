package com.xeon.javaclash.protocol.messages.client.login;

import com.xeon.javaclash.core.Connection;
import com.xeon.javaclash.core.Debugger;
import com.xeon.javaclash.logic.Player;
import com.xeon.javaclash.protocol.messages.PiranhaMessage;
import com.xeon.javaclash.protocol.messages.server.home.OwnHomeDataMessage;
import com.xeon.javaclash.protocol.messages.server.login.LoginFailedMessage;
import com.xeon.javaclash.protocol.messages.server.login.LoginOkMessage;

public class ClientHelloMessage extends PiranhaMessage {
    public ClientHelloMessage(int id, byte[] payload, Connection connection) {
        super(id, payload, connection);
    }

    public int Protocol;
    public int KeyVersion;
    public int MajorVersion;
    public int MinorVersion;
    public int Build;
    public string FingerprintSha;
    public int DeviceType;
    public int AppStore;

    @Override
    public void process(){
      // already decrypted
    }

    @Override
    public void decode(){
        Protocol = reader.readInt();
        KeyVersion = reader.readInt();
        MajorVersion = reader.readInt();
        MinorVersion = reader.readInt();
        Build = reader.readInt();
        //FingerprintSha = reader.readInt();
        DeviceType = reader.readInt();
        AppStore = reader.readInt();
    }

    @Override
    public void process(){
    }
}
