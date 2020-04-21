# react-native-modbus-tcp

This is a React Native module to help you process modbus data.
This Library is only for <b>android</b> at the moment.

`npm package:` <a href="https://www.npmjs.com/package/react-native-modbus-tcp" target="_blank">https://www.npmjs.com/package/react-native-modbus-tcp</a>

## What does Modbus TCP/IP mean?

Modbus TCP/IP is a simple Modbus protocol running on Ethernet over a TCP interface. Modbus is an application protocol that assigns the ways of managing and passing data between various layers without being affected by the protocol used by the next immediate layer.

Modbus TCP/IP is also known as Modbus-TCP.

## Getting started

`$ npm install react-native-modbus-tcp --save`

### Mostly automatic installation

`$ react-native link react-native-modbus-tcp`

if your `React Native` version is >=0.60.0 you don't have to use the command above.

## Usage

`Connect to Modbus TCP Master`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

// Connect to Modbus TCP Master (parameters [ip, port])
    ModbusTcp.connectToModbusMaster('192.168.137.32', 502, (res) => {
      // Do something with the response
      // If Success response ==> Modbus4Android init success
      // if response is not success ==> Modbus4Android init success
    });
```

`Read Single Coil`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

    // Read Coil (parameters [slaveid, start, length])
    ModbusTcp.readCoil(248, 1, 2, (res) => {
      // Do something with the response
      // If Success response ==> [false,false] etc...
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Read Discrete Input`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

    // Read Discrete Input (parameters [slaveid, start, length])
    ModbusTcp.readDiscreteInput(248, 1, 5, (res) => {
      // Do something with the response
      // If Success response ==> [false,false,false,true,true] etc...
      // if response is not success ==> Modbus master is not inited successfully...
    });
```
`Read Holding Registers`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

    // Read Holding Registers (parameters [slaveid, start, length])
    ModbusTcp.readHoldingRegisters(248, 2, 8, (res) => {
      // Do something with the response
      // If Success response ==> [0,0,0,0,0,0,0,0] etc...
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Read input registers`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Read Input Registers (parameters [slaveid, start, length])
    ModbusTcp.readInputRegisters(248, 2, 8, (res) => {
      // Do something with the response
      // If Success response ==> [0,0,0,0,0,0,0,0] etc...
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Write single coil`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Write Coil (parameters [slaveid, offset, value])
    ModbusTcp.writeCoil(248, 1, true, (res) => {
      // Do something with the response
      // If Success response ==> Success
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Write multiple coils`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Write Coils (parameters [slaveid, start, values])
    ModbusTcp.writeCoils(248, 2, [true,true,true,true], (res) => {
      // Do something with the response
      // If Success response ==> Success
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Write single holding register`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Write Register (parameters [slaveid, offset, value])
    ModbusTcp.writeRegister(248, 1, 150, (res) => {
      // Do something with the response
      // If Success response ==> Success
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Write multiple holding registers`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Write Registers (parameters [slaveid, start, values])
    ModbusTcp.writeRegisters(248, 2, [500,505,304,1004,600], (res) => {
      // Do something with the response
      // If Success response ==> Success
      // if response is not success ==> Modbus master is not inited successfully...
    });
```

`Destroy the connection between the slave and the master`
```javascript
import ModbusTcp from 'react-native-modbus-tcp';

  // Destroy Connection
      ModbusTcp.destroyConnection((res) => {
        
        // Do something with the response
        // response ==> Connection destroyed
      });
```

## Methods

<ul>
    <li>connectToModbusMaster</li>
    <li>readCoil</li>
    <li>readDiscreteInput</li>
    <li>readHoldingRegisters</li>
    <li>readInputRegisters</li>
    <li>writeCoil</li>
    <li>writeCoils</li>
    <li>writeRegister</li>
    <li>writeRegisters</li>
    <li>destroyConnection</li>
</ul>

Addresses are exactly as is in protocol, so if you see a paper talking about address 40001 this usually means first record address of that function so it means address 0.

## Contributing

Pull requests welcome with bug fixes, documentation improvements, and enhancements.

When making big changes, please open an issue first to discuss.

## License

This project is licensed under the MIT License.