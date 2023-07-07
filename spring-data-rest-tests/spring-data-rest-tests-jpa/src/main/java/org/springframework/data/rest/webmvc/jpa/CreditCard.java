/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.rest.webmvc.jpa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author Oliver Gierke
 */
@Entity
public class CreditCard {

	@Id Long id;
	final @JsonUnwrapped CCN ccn;

	public CreditCard(CCN ccn) {
		this.ccn = ccn;
	}

	public Long getId() {
		return this.id;
	}

	public CCN getCcn() {
		return this.ccn;
	}

	@Embeddable
	public static class CCN {
		String ccn;

		public CCN(String ccn) {
			this.ccn = ccn;
		}

		public CCN() {}

		public String getCcn() {
			return this.ccn;
		}
	}
}
