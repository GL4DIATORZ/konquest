package konquest.manager;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import konquest.Konquest;
import konquest.model.KonConfig;
import konquest.utility.ChatUtil;

public class ConfigManager{
	
	private Konquest konquest;
	private HashMap<String, KonConfig> configCache;
	
	public ConfigManager(Konquest konquest) {
		this.konquest = konquest;
        this.configCache = new HashMap<String, KonConfig>();
	}
        
	public void initialize() {
		addConfig("core", new KonConfig("core.yml"));
		updateConfigVersion("core");
		addConfig("upgrades", new KonConfig("upgrades.yml"));
		addConfig("camps", new KonConfig("camps.yml"));
		addConfig("kingdoms", new KonConfig("kingdoms.yml"));
		addConfig("ruins", new KonConfig("ruins.yml"));
		
        System.out.println("[DEBUG]: Debug is "+getConfig("core").getBoolean("core.debug"));
	}
	
	public FileConfiguration getConfig(String key) {
		return configCache.get(key).getConfig();
	}
	
	public void addConfig(String key, KonConfig config) {
		config.saveDefaultConfig();
		config.reloadConfig();
		configCache.put(key, config);
	}
	
	public HashMap<String, KonConfig> getConfigCache() {
		return configCache;
	}
	
	public Konquest getKonquest() {
		return konquest;
	}
	
	public void reloadConfigs() {
		for (KonConfig config : configCache.values()) {
			config.reloadConfig();
		}
	}
	
	public void saveConfigs() {
		for (KonConfig config : configCache.values()) {
			config.saveConfig();
		}
	}
	
	public void saveConfig(String name) {
		if(configCache.containsKey(name)) {
			configCache.get(name).saveConfig();
		} else {
			ChatUtil.printDebug("ERROR: Tried to save non-existant config "+name);
		}
	}
	
	public void updateConfigVersion(String name) {
		if(configCache.containsKey(name)) {
			configCache.get(name).updateVersion();
		} else {
			ChatUtil.printDebug("ERROR: Tried to update non-existant config "+name);
		}
	}
	
	public void overwriteBadConfig(String key) {
		configCache.get(key).saveNewConfig();
		configCache.get(key).reloadConfig();
		Konquest.getInstance().getPlugin().getServer().getConsoleSender().sendMessage(ChatColor.RED+"[Konquest] ERROR: Bad config file \""+key+"\", saved default version");
	}

}
