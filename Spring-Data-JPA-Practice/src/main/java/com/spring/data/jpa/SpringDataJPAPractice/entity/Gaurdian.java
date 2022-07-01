package com.spring.data.jpa.SpringDataJPAPractice.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
	//Since we have changed the structure of the student entity and we want to make sure that the gaurdian data
	//should be coming in the student table only so we we are marking it as the embeddable and giving the name 
	//of the columns where the respective values should get stored using AttributesOverrides
	@AttributeOverride(
			name = "name",
			column = @Column(
					name = "gaurdian_name"
			)
	),
	@AttributeOverride(
			name = "emailId",
			column = @Column(
					name = "gaurdian_email_id"
			)
	),
	@AttributeOverride(
			name = "mobile",
			column = @Column(
					name = "gaurdian_mobile"
			)
	)
})
public class Gaurdian {

	private String name;
	private String emailId;
	private String mobile;
}
