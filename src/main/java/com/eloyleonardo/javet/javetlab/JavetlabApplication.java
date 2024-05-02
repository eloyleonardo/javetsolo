package com.eloyleonardo.javet.javetlab;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;

public class JavetlabApplication {

	public static void main(String[] args) throws JavetException {
		try (V8Runtime v8Runtime = V8Host.getV8Instance().createV8Runtime()) {
			System.out.println(v8Runtime.getExecutor("'Hello Javet'").executeString());
        }
	}
}
