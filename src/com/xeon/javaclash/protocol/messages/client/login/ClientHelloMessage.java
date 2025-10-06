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

    private int playerID;
    public int Protocol;
    public int KeyVersion;
    public int MajorVersion;
    public int MinorVersion;
    public int Build;
    public String FingerprintSha;
    public int DeviceType;
    public int AppStore;
    @Override
    public void decode(){
        reader.readInt(); //HighID
        this.playerID = reader.readInt(); //LowID

        Protocol = reader.readInt();
        KeyVersion = reader.readInt();
        MajorVersion = reader.readInt();
        MinorVersion = reader.readInt();
        Build = reader.readInt();
        FingerprintSha = reader.readString();
        DeviceType = reader.readInt();
        AppStore = reader.readInt();
    }

    @Override
    public void process(){
        this.connection.player = Player.load(playerID);
        LoginFailedMessage fail = new LoginFailedMessage(this.connection);
        fail.reason = "Not implemented yet.";
        this.connection.messaging.sendMessage(fail);
    }
}
