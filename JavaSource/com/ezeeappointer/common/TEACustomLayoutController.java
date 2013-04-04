package com.ezeeappointer.common;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.layout.LayoutOptions;

/**
 * @author dreddy
 *
 */
 
@ManagedBean(name="layoutController")
@ViewScoped
public class TEACustomLayoutController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7252775283012537260L;
	private LayoutOptions layoutOptions;

	@PostConstruct
	protected void initialize() {
		layoutOptions = new LayoutOptions();

//		// options for all panes
//		LayoutOptions panes = new LayoutOptions();
//		panes.addOption("slidable", false);
//		panes.addOption("spacing", 6);
//		layoutOptions.setPanesOptions(panes);

		// north pane
		LayoutOptions north = new LayoutOptions();
		north.addOption("resizable", false);
		north.addOption("closable", false);
		north.addOption("size", 60);
		north.addOption("spacing_open", 0);
		layoutOptions.setNorthOptions(north);

		// south pane
		LayoutOptions south = new LayoutOptions();
		south.addOption("resizable", false);
		south.addOption("closable", false);
		south.addOption("size", 28);
		south.addOption("spacing_open", 0);
		layoutOptions.setSouthOptions(south);

		

		LayoutOptions center = new LayoutOptions();
		center.addOption("resizable", false);
		center.addOption("closable", false);

		layoutOptions.setCenterOptions(center);

		// set options for nested center layout
		LayoutOptions optionsNested = new LayoutOptions();
		center.setChildOptions(optionsNested);

		// options for center-north pane
		LayoutOptions centerNorth = new LayoutOptions();
		centerNorth.addOption("size", "50%");
		optionsNested.setNorthOptions(centerNorth);

		// options for center-center pane
		LayoutOptions centerCenter = new LayoutOptions();
		centerCenter.addOption("minHeight", 60);
		optionsNested.setCenterOptions(centerCenter);
	}

	public LayoutOptions getLayoutOptions() {
		return layoutOptions;
	}

}
            