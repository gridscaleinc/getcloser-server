/**
 *
 */
package com.gridscale.mpath.api.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * APIの処理結果を返す。
 *
 * @author doman
 *
 */
public class Result implements Serializable {

	private String status = "";
	private boolean haswarning = false;
	private List<String> warningMessages = new ArrayList<>();
	private List<String> errorMessages  = new ArrayList<>();

	/**
	 * OK結果時利用。
	 */
	public static Result OK = new Result("OK");

	/**
	 * Bare Constructor.
	 */
	public Result() {

	}

	/**
	 * Status指定コンストラクタ。
	 *
	 * @param status
	 */
	public Result(String status) {
		this.status = status;
	}

	/**
	 * Warningメッセージ追加。
	 *
	 * @param message warning messsage.
	 */
	public void addWarn( String message) {

		this.haswarning = true;
		this.warningMessages.add(message);
	}


	/**
	 * status
	 * String
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status セットする status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * haswarning
	 * boolean
	 *
	 * @return haswarning
	 */
	public boolean isHaswarning() {
		return haswarning;
	}

	/**
	 * @param haswarning セットする haswarning
	 */
	public void setHaswarning(boolean haswarning) {
		this.haswarning = haswarning;
	}

	/**
	 * warningMessages
	 * List<String>
	 *
	 * @return warningMessages
	 */
	public List<String> getWarningMessages() {
		return warningMessages;
	}

	/**
	 * @param warningMessages セットする warningMessages
	 */
	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

	/**
	 * errorMessages
	 * List<String>
	 *
	 * @return errorMessages
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * @param errorMessages セットする errorMessages
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
