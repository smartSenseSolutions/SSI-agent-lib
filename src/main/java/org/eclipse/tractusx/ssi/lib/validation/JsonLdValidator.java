/*
 * ******************************************************************************
 * Copyright (c) 2021,2024 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * *******************************************************************************
 */

package org.eclipse.tractusx.ssi.lib.validation;

import org.eclipse.tractusx.ssi.lib.exception.json.InvalidJsonLdException;
import org.eclipse.tractusx.ssi.lib.model.verifiable.Verifiable;

/** The json-ld validator interface */
public interface JsonLdValidator {

  /**
   * Validate an object adhering to the 'Verifiable' contract (usually a VC or VP)
   *
   * @param verifiable an object adhering to the 'Verifiable' contract
   * @throws InvalidJsonLdException is thrown if the verifiable object is not valid json-ld
   */
  void validate(Verifiable verifiable) throws InvalidJsonLdException;
}
