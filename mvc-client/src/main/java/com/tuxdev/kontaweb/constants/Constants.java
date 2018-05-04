package com.tuxdev.kontaweb.constants;

/**
 * <p>
 * Class Constants
 * <p>
 * This class contains constant values used in the application.
 *
 * @author Tuxdev
 * @version 1.0
 */
public class Constants  {

	/**
	 * Instantiates a new constants.
	 */
	public Constants() {

	}



	public static enum Results {

		VIEW_SIGNED_IN("index"),VIEWS("views/");

		/**
		 * Instantiates a new results.
		 *
		 * @param value the value
		 */
		private Results(String value){
			this.value = value;
		}

		String value;

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

	}	

}
