package com.reactlibrary;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.zgkxzx.modbus4And.requset.ModbusParam;
import com.zgkxzx.modbus4And.requset.ModbusReq;
import com.zgkxzx.modbus4And.requset.OnRequestBack;

import java.util.Arrays;

import static android.content.ContentValues.TAG;

public class ModbusTcpModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public ModbusTcpModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ModbusTcp";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    // Connect to Modbus TCP Master
    @ReactMethod
    public void connectToModbusMaster(String ip, int port, final Callback cb) {

        ModbusReq.getInstance().setParam(new ModbusParam()
//               .setHost("192.168.10.4")
                .setHost(ip)
                .setPort(port)
                .setEncapsulated(false)
                .setKeepAlive(true)
                .setTimeout(2000)
                .setRetries(0))
                .init(new OnRequestBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Log.d(TAG, "onSuccess " + s);
                        cb.invoke(s.toString(),null);
                    }

                    @Override
                    public void onFailed(String msg) {
                        Log.d(TAG, "onFailed " + msg);
                        cb.invoke(msg.toString(), null);
                    }
                });
    }

    // Read Coil
    @ReactMethod
    public void readCoil(int slaveid, int start, int len, final Callback cb) {

        ModbusReq.getInstance().readCoil(new OnRequestBack<boolean[]>() {
            @Override
            public void onSuccess(boolean[] booleen) {
                Log.d(TAG, "readCoil onSuccess " + Arrays.toString(booleen));
                cb.invoke(Arrays.toString(booleen), null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "readCoil onFailed " + msg);
                cb.invoke(msg, null);
            }
        }, slaveid, start, len);
    }

    // Read Discrete Inputs
    @ReactMethod
    public void readDiscreteInput(int slaveid, int start, int len, final Callback cb) {

        ModbusReq.getInstance().readDiscreteInput(new OnRequestBack<boolean[]>() {
            @Override
            public void onSuccess(boolean[] booleen) {
                Log.d(TAG, "readDiscreteInput onSuccess " + Arrays.toString(booleen));
                cb.invoke(Arrays.toString(booleen), null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "readDiscreteInput onFailed " + msg);
                cb.invoke(msg, null);
            }
        },slaveid,start,len);
    }

    // Read Holding Registers
    @ReactMethod
    public void readHoldingRegisters(int slaveid, int start, int len, final Callback cb) {

        ModbusReq.getInstance().readHoldingRegisters(new OnRequestBack<short[]>() {
            @Override
            public void onSuccess(short[] data) {
                Log.d(TAG, "readHoldingRegisters onSuccess " + Arrays.toString(data));
                cb.invoke(Arrays.toString(data), null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "readHoldingRegisters onFailed " + msg);
                cb.invoke(msg, null);
            }
        }, slaveid, start, len);
    }

    // Read Input Registers
    @ReactMethod
    public void readInputRegisters(int slaveid, int start, int len, final Callback cb) {

        ModbusReq.getInstance().readInputRegisters(new OnRequestBack<short[]>() {
            @Override
            public void onSuccess(short[] data) {
                Log.d(TAG, "readInputRegisters onSuccess " + Arrays.toString(data));
                cb.invoke(Arrays.toString(data), null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "readInputRegisters onFailed " + msg);
                cb.invoke(msg, null);
            }
        }, slaveid, start, len);
    }

    // Write Coil
    @ReactMethod
    public void writeCoil(int slaveid, int offset, boolean value, final Callback cb) {

        ModbusReq.getInstance().writeCoil(new OnRequestBack<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e(TAG, "writeCoil onSuccess " + s);
                cb.invoke(s, null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "writeCoil onFailed " + msg);
                cb.invoke(msg, null);
            }
        },slaveid,offset,value);
    }

    // Write Coils
    @ReactMethod
    public void writeCoils(int slaveid, int start, ReadableArray booleanArray, final Callback cb) {

        boolean values[] = new boolean[booleanArray.size()];

        for(int i = 0; i < booleanArray.size(); i++)
        {
            values[i] = (boolean)booleanArray.getBoolean(i);
        }

        ModbusReq.getInstance().writeCoils(new OnRequestBack<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e(TAG, "writeCoil onSuccess " + s);
                cb.invoke(s, null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "writeCoil onFailed " + msg);
                cb.invoke(msg, null);
            }
        },slaveid,start,values);
    }

    // Write Register
    @ReactMethod
    public void writeRegister(int slaveid, int offset, int value, final Callback cb) {

        ModbusReq.getInstance().writeRegister(new OnRequestBack<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e(TAG, "writeRegister onSuccess " + s);
                cb.invoke(s, null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "writeRegister onFailed " + msg);
                cb.invoke(msg, null);
            }
        },slaveid,offset,value);
    }

    // Write Registers
    @ReactMethod
    public void writeRegisters(int slaveid, int start, ReadableArray readableMap , final Callback cb) {

        short inShort[] = new short[readableMap.size()];

        for(int i = 0; i < readableMap.size(); i++)
        {
            inShort[i] = (short)readableMap.getInt(i);
        }

        ModbusReq.getInstance().writeRegisters(new OnRequestBack<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e(TAG, "writeRegisters onSuccess " + s);
                cb.invoke(s, null);
            }

            @Override
            public void onFailed(String msg) {
                Log.e(TAG, "writeRegisters onFailed " + msg);
                cb.invoke(msg, null);
            }
        },slaveid,start,inShort);
    }

    // Destroy connection
    @ReactMethod
    public void destroyConnection(Callback cb) {
        ModbusReq.getInstance().destory();

        cb.invoke("Connection destroyed");
    }
}
