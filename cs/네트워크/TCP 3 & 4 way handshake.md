## TCP 3 & 4 way handshake

> TCP 프로토콜에서 연결을 성립하고 해제하는 과정을 말한다.

### 3 way handshake - 연결 성립

TCP는 정확한 전송을 보장해야 한다.(신뢰성) 따라서 통신하기에 앞서, 논리적인 접속을 성립하기 위해 3 way handshake 과정을 진행한다.

![3 way handshake](/cs/네트워크/img/3%20way%20handshake.png)

1. 클라이언트가 서버에게 SYN 패킷을 전송 (sequence: x)
2. 서버는 STN(x)를 받고, 클라이언트로 부터 받았다는 신호인 ACK와 SYN 패킷을 전송 (sequence: x, ACK: x + 1)
3. 클라이언트는 서버의 응답인 ACK(x + 1)과 SYN(y)를 받고, ACK(y + 1)을 서버로 전송

이렇게 3번의 통신이 완료되면 연결이 성립된다.

### 4 way handshake - 연결 해제

연결 성립 후, 모든 통신이 끝났다면 해제해야 한다.

![4 way handshake](/cs/네트워크/img/4%20way%20handshake.png)

1. 클라이언트는 서버에 연결을 종료하겠다는 FIN 플래그를 전송
2. 서버는 FIN을 받고, 확인했다는 ACK를 클라이언트에게 전송(이 때 모든 데이터를 보내기 위해 CLOSE_WAIT 상태가 된다.)
3. 서버에서 클라이언트에게 데이터를 모두 보냈다면, 연결이 종료되었다는 FIN 플래그를 클라이언트에게 보낸다.
4. 클라이언트는 FIN을 받고, 확인했다는 ACK를 서버에게 전송(아직 서버로부터 받지 못한 데이터가 있을 수 있으므로 TIME_WAIT을 통해 기다린다.)

- 서버는 4번 단계를 통해 ACK를 전달 받으면 소켓을 닫는다(Closed)
- TIME_WAIT 시간이 끝나면 클라이언트도 소켓을 닫는다(Closed)

이렇게 4번의 통신이 완료되면 연결이 해제된다.
