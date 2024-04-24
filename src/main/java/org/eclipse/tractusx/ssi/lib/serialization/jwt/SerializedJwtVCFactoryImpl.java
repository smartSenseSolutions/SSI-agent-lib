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

package org.eclipse.tractusx.ssi.lib.serialization.jwt;

import com.nimbusds.jwt.SignedJWT;
import java.util.LinkedHashMap;
import lombok.RequiredArgsConstructor;
import org.eclipse.tractusx.ssi.lib.crypt.IPrivateKey;
import org.eclipse.tractusx.ssi.lib.jwt.SignedJwtFactory;
import org.eclipse.tractusx.ssi.lib.model.did.Did;
import org.eclipse.tractusx.ssi.lib.model.verifiable.credential.VerifiableCredential;

/** A concrete implementation of the serialized VC as JWT contract */
@RequiredArgsConstructor
public class SerializedJwtVCFactoryImpl implements SerializedJwtVCFactory {
  private final SignedJwtFactory signedJwtFactory;

  @Override
  public SignedJWT createVCJwt(
      Did issuer,
      Did holder,
      VerifiableCredential credentials,
      IPrivateKey privateKey,
      String keyId) {
    var clonedVC = new LinkedHashMap<String, Object>();
    clonedVC.putAll(credentials);
    return signedJwtFactory.create(issuer, holder, clonedVC, privateKey, keyId);
  }
}
