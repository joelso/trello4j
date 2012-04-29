package org.trello4j.model;

import java.util.Date;

/**
 * The Class Token.
 */
public class Token extends TrelloObject {

	/**
	 * <code>
	 * {
	 * "id": "4ee7f1e00081da1fcb00014b",
	 * "idMember": "4ee7df3ce582acdec80000b2",
	 * "dateCreated": "2011-12-14T00:46:24.534Z",
	 * "dateExpires": "2020-01-01T00:00:00.000Z",
	 * "permissions": [{
	 *    "idModel": "*",
	 *    "modelType": "*",
	 *    "read": true,
	 *    "write": false
	 * }]
	 * }
	 * 
	 * </code>
	 */

	String idMember;

	/** The date created. */
	Date dateCreated;

	/** The date expires. */
	Date dateExpires;

	/** The permissions. */
	java.util.List<Permission> permissions;

	/**
	 * Gets the id member.
	 * 
	 * @return the id member
	 */
	public String getIdMember() {
		return idMember;
	}

	/**
	 * Sets the id member.
	 * 
	 * @param idMember
	 *            the new id member
	 */
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	/**
	 * Gets the date created.
	 * 
	 * @return the date created
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Sets the date created.
	 * 
	 * @param dateCreated
	 *            the new date created
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Gets the date expires.
	 * 
	 * @return the date expires
	 */
	public Date getDateExpires() {
		return dateExpires;
	}

	/**
	 * Sets the date expires.
	 * 
	 * @param dateExpires
	 *            the new date expires
	 */
	public void setDateExpires(Date dateExpires) {
		this.dateExpires = dateExpires;
	}

	/**
	 * The Class Permission.
	 */
	public class Permission {

		/**
		 * Gets the id model.
		 * 
		 * @return the id model
		 */
		public String getIdModel() {
			return idModel;
		}

		/**
		 * Sets the id model.
		 * 
		 * @param idModel
		 *            the new id model
		 */
		public void setIdModel(String idModel) {
			this.idModel = idModel;
		}

		/**
		 * Gets the model type.
		 * 
		 * @return the model type
		 */
		public String getModelType() {
			return modelType;
		}

		/**
		 * Sets the model type.
		 * 
		 * @param modelType
		 *            the new model type
		 */
		public void setModelType(String modelType) {
			this.modelType = modelType;
		}

		/**
		 * Checks if is read.
		 * 
		 * @return true, if is read
		 */
		public boolean isRead() {
			return read;
		}

		/**
		 * Sets the read.
		 * 
		 * @param read
		 *            the new read
		 */
		public void setRead(boolean read) {
			this.read = read;
		}

		/**
		 * Checks if is write.
		 * 
		 * @return true, if is write
		 */
		public boolean isWrite() {
			return write;
		}

		/**
		 * Sets the write.
		 * 
		 * @param write
		 *            the new write
		 */
		public void setWrite(boolean write) {
			this.write = write;
		}

		/** The id model. */
		String idModel;

		/** The model type. */
		String modelType;

		/** The read. */
		boolean read;

		/** The write. */
		boolean write;
	}
}
