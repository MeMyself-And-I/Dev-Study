# PCB & Context Switching

## PCB(Process Control Block)

> 프로세스 메타데이터들을 저장해 놓는 곳, 한 PCB안에는 하나의 프로세스의 정보가 담김

**_Process Metadata란?_**

CPU의 프로세스가 여러개 일 때 CPU는 각 프로세스들이 누군지 알아야 관리가 가능함.

이 프로세스들의 특징(정보)를 가지고 있는 것이 Process Metadata

- Process Metadata
  - Process ID
  - Process State
  - Process Priority
  - CPU Registers
  - Owner
  - CPU Usage
  - Memory Usage

메타데이터는 프로세스가 생성되면 PCB에 저장됨

![PCB](/cs/운영체제/img/PCB.png)

**_PCB가 필요한 이유_**

CPU에서는 프로세스의 상태에 따라 교체 작업이 이루어진다.
이 때, 앞으로 다시 수행할 대기 중인 프로세스에 관한 저장 값을 PCB에 저장해두는 것이다.

**_PCB는 어떻게 관리가 될까?_**

연결 리스트(Linked List) 구조로 관리된다.

주소값으로 연결이 이루어져 있는 연결 리스트이기 때문에 삽입 및 삭제가 용이하다.

즉, 프로세스가 생성되면 해당 프로세스의 PCB가 생성되고 프로세스 완료 시 삭제된다.

이렇게 수행 중인 프로세스를 변경할 떄, CPU의 레지스터 정보가 변경되는 것을 Context Switching이라고 한다.

## Context Switching

> CPU가 이전의 프로세스 상태를 PCB에 보관하고, 또 다른 프로세스 정보를 PCB에서 읽어 레지스터에 적재하는 과정

보통 인터럽트가 발생하거나, 실행 중인 CPU 사용 허가시간을 초과하거나, I/O를 위해 대기해야 하는 경우에 발생한다.

**_즉, 프로세스가 Ready -> Running, Running -> Ready, Running -> Waiting처럼 상태 변경 시 발생_**

**_Context Switching의 오버헤드_**

프로세스는 작업 중에 효율성을 위해 OverHead를 감수해야 하는 상황이 있는데,

예를 들어 프로세스를 수행하다가 I/O 이벤트가 발생하여 대기 상태로 전환 시키고나서 CPU를 그냥 놀게 두는 것이 아닌 다른 프로세스를 수행시키는 것이 효율적이기 떄문에 Context Switching을 통해 PCB에 이전 정보를 저장하고 다른 프로세스를 실행 시키도록 한다.
-> CPU를 놀지 않도록 하여, 사용자에게 빠른 일처리를 제공해주기 위함
