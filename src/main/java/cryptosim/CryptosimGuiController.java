package cryptosim;

import org.springframework.stereotype.Component;

@Component
public class CryptosimGuiController {

	private final CryptosimGuiView view;

	public CryptosimGuiController(CryptosimGuiView view) {
		this.view = view;
	}

	public CryptosimGuiView getView() {
		return view;
	}

}
