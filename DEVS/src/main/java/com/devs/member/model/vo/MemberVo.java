package com.devs.member.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "MEMBER")
public class MemberVo {

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
	private String memberid;

	@Column(name = "MEMBER_PASSWORD")
	private String memberpassword;

	@Column(name = "SNS_TYPE")
	private String snstype;

	@Column(name = "SNS_ID")
	private String snsid;

	@Builder
	public MemberVo(String memberemail, String memberphone, String membername, String memberid, String memberpassword,
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