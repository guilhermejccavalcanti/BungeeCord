package net.md_5.bungee.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet2Handshake extends DefinedPacket
{

    public byte procolVersion;
    public String username;
    public String host;
    public int port;

    public Packet2Handshake(byte protocolVersion, String username, String host, int port)
    {
        super( 0x02 );
        writeByte( protocolVersion );
        writeString( username );
        writeString( host );
        writeInt( port );
        this.procolVersion = protocolVersion;
        this.username = username;
        this.host = host;
        this.port = port;
    }

    Packet2Handshake(ByteBuf buf)
    {
        super( 0x02, buf );
        this.procolVersion = readByte();
        this.username = readString();
        this.host = readString();
        this.port = readInt();
    }

    @Override
    public void handle(PacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
