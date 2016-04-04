package com.dogonfire.werewolf.versioning;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class VersionFactory
{
	/**
	 * Factory method used when you want to construct a Version object via a
	 * Plugin object. <br/>
	 */
	public static Version getPluginVersion(Plugin plugin)
	{
		String version = (plugin == null) ? null : plugin.getDescription().getVersion();
		Tester tester = TesterFactory.getNewTester(plugin);
		return new Version(version, tester, plugin);
	}

	/**
	 * Factory method used when you want to construct a Version object via
	 * pluginName. <br/>
	 */
	public static Version getPluginVersion(String pluginName)
	{
		Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
		String version = (plugin == null) ? null : plugin.getDescription().getVersion();
		Tester tester = TesterFactory.getNewTester(plugin);
		return new Version(version, tester, plugin);
	}

	/**
	 * Factory method to conveniently construct a Version object of the server. <br/>
	 */
	public static Version getServerVersion()
	{
		String version = Bukkit.getServer().getBukkitVersion();
		return new Version(version);
	}

	/**
	 * Factory method to conveniently construct a Version object of
	 * net.minecraft.server.v1_X_RY package. <br/>
	 */
	public static Version getNmsVersion()
	{
		String NMS = null;
		try
		{
			NMS = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			NMS = "pre";
		}
		return new Version(NMS);
	}

}