package org.trello4j;

/**
 * The Class TrelloUtil.
 */
public class TrelloUtil {

	/**
	 * "Stolen" from: https://github.com/mongodb/mongo-java-driver
	 * 
	 * @param id String to validate
	 * @return true, if is object id valid
	 */
	public static boolean isObjectIdValid(String s) {
		if (s == null)
			return false;

		final int len = s.length();
		if (len != 24)
			return false;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			if (c >= 'a' && c <= 'f')
				continue;
			if (c >= 'A' && c <= 'F')
				continue;

			return false;
		}

		return true;
	}
}
