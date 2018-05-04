package org.jasrodis.bootfx;

import org.springframework.stereotype.Component;

@Component
public class BootFxController {

	private final BootFxView view;

	public BootFxController(BootFxView view) {
		this.view = view;
	}

	public BootFxView getView() {
		return view;
	}

}
