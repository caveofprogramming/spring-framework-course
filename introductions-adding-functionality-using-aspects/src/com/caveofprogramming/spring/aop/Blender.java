package com.caveofprogramming.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Blender implements IBlender {
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.IBlender#blend()
	 */
	@Override
	public void blend() {
		System.out.println("Blending ...");
	}
}
