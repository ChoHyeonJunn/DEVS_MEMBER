package com.devs.member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_CODE")
	private int membercode;

	@Column(name = "MEMBER_EMAIL")
	private String memberemail;

	@Column(name = "MEMBER_PHONE")
	private String memberphone;

	@Column(name = "MEMBER_NAME")
	private String membername;

	@Column(name = "MEMBER_ID")
	@NonNull
	private String memberid;

	@Column(name = "MEMBER_PASSWORD")
	@NonNull
	private String memberpassword;

	@Column(name = "SNS_TYPE")
	private String snstype;

	@Column(name = "SNS_ID")
	private String snsid;

	@Builder
	public Member(String memberemail, String memberphone, String membername, String memberid, String memberpassword,
			String snstype, String snsid) {
		super();
		this.memberemail = memberemail;
		this.memberphone = memberphone;
		this.membername = membername;
		this.memberid = memberid;
		this.memberpassword = memberpassword;
		this.snstype = snstype;
		this.snsid = snsid;
	}

}
