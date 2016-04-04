package com.dogonfire.werewolf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.ObjectUtils;

import net.minecraft.server.v1_9_R1.DataWatcher;
import net.minecraft.server.v1_9_R1.Entity;

public class WerewolfDataWatcher<WatchableObject> extends DataWatcher
{
	static Method	iMethod;
	static Field	eBoolean;

	static
	{
		try
		{
			iMethod = DataWatcher.class.getDeclaredMethod("j", new Class[] { Integer.TYPE });
			iMethod.setAccessible(true);			
		}
		catch (Exception localException1)
		{
		}
		
		try
		{
			eBoolean = DataWatcher.class.getDeclaredField("e");
			eBoolean.setAccessible(true);
		}
		catch (Exception localException2)
		{
		}
	}

	public WerewolfDataWatcher(Entity arg0)
	{
		super(arg0);
	}

	public void watch(int paramInt, Object paramObject)
	{
		WatchableObject localWatchableObject = null;
		try
		{
			localWatchableObject = (WatchableObject) iMethod.invoke(this, new Object[] { Integer.valueOf(paramInt) });
		}
		catch (Exception localException)
		{
		}
		
		if (ObjectUtils.notEqual(paramObject, ((DataWatcher) localWatchableObject).b()))
		{
			((DataWatcher) localWatchableObject).a();
			((DataWatcher) localWatchableObject).a();
			try
			{
				eBoolean.setBoolean(this, true);
			}
			catch (Exception localException1)
			{
			}
		}
	}

	public void a(int i, byte b) {
		// TODO Auto-generated method stub
		
	}

	public void a(int i, String accountName) {
		// TODO Auto-generated method stub
		
	}

	public void a(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
