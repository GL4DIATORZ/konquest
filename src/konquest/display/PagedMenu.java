package konquest.display;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import konquest.utility.ChatUtil;

public class PagedMenu {

	private ArrayList<DisplayMenu> pages;
	private int currentPageIndex;
	
	public PagedMenu() {
		this.pages = new ArrayList<DisplayMenu>();
		this.currentPageIndex = 0;
	}
	
	/*
	 * Pages must have a bottom row dedicated to navigation buttons
	 */
	
	public void addPage(int index, int rows, String label) {
		if(index > pages.size()) {
			ChatUtil.printDebug("Failed to add page beyond list index");
			return;
		}
		if(rows > 5) {
			ChatUtil.printDebug("Failed to add page with too many rows");
			return;
		}
		pages.add(index, new DisplayMenu(rows+1, label));
	}
	
	public DisplayMenu getPage(int index) {
		if(index < 0 || index > pages.size()) {
			ChatUtil.printDebug("Failed to get page beyond list index");
			return null;
		}
		return pages.get(index);
	}
	
	public void setPageIndex(int index) {
		if(index < 0 || index > pages.size()) {
			ChatUtil.printDebug("Failed to set page beyond list index");
		} else {
			currentPageIndex = index;
		}
	}
	
	public int nextPageIndex() {
		int newIndex = currentPageIndex+1;
		if(newIndex < pages.size()) {
			currentPageIndex = newIndex;
		}
		return currentPageIndex;
	}
	
	public int previousPageIndex() {
		int newIndex = currentPageIndex-1;
		if(newIndex >= 0) {
			currentPageIndex = newIndex;
		}
		return currentPageIndex;
	}
	
	public int currentPageIndex() {
		return currentPageIndex;
	}
	
	public DisplayMenu getCurrentPage() {
		if(currentPageIndex < 0 || currentPageIndex > pages.size()) {
			ChatUtil.printDebug("Failed to get page beyond list index");
			return null;
		}
		return pages.get(currentPageIndex);
	}
	
	public DisplayMenu getPage(Inventory inv) {
		DisplayMenu result = null;
		for(DisplayMenu menu : pages) {
			if(menu.getInventory().equals(inv)) {
				result = menu;
			}
		}
		return result;
	}
	
	public void refreshNavigationButtons() {
		// Place a back button on pages > 0
		// Place a next button on pages < max
		// Place a close button on all pages
		InfoIcon navigationButton;
		for(int i=0;i<pages.size();i++) {
			int nextIndex = pages.get(i).getInventory().getSize()-1;
			int closeIndex = pages.get(i).getInventory().getSize()-5;
			int backIndex = pages.get(i).getInventory().getSize()-9;
			if(i > 0) {
				// Place a back button
				navigationButton = new InfoIcon("Back",Arrays.asList(""),Material.REDSTONE_TORCH,backIndex);
				pages.get(i).addIcon(navigationButton);
			}
			if(i < pages.size()-1) {
				// Place a next button
				navigationButton = new InfoIcon("Next",Arrays.asList(""),Material.REDSTONE_BLOCK,nextIndex);
				pages.get(i).addIcon(navigationButton);
			}
			// Place a close button
			navigationButton = new InfoIcon("Close",Arrays.asList(""),Material.REDSTONE_TORCH,closeIndex);
			pages.get(i).addIcon(navigationButton);
		}
	}
	
}
