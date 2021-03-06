/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.certificateauthority.crl;

import org.wso2.carbon.identity.certificateauthority.CaException;
import org.wso2.carbon.identity.certificateauthority.dao.CrlDataHolderDao;

import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.X509CRL;

public class CrlStore {
    CrlDataHolderDao crlDataHolderDao = new CrlDataHolderDao();

    /**
     * to get the latest full crl or delta crl for a tenant
     *
     * @param tenantId tenant id
     * @param deltaCrl true if requesting a delta crl, false if requesting full crl
     * @return a X509Crl
     * @throws CertificateException
     * @throws CaException
     */
    public byte[] getLatestCrl(int tenantId, boolean deltaCrl) throws CertificateException, CaException, CRLException {
        return crlDataHolderDao.getLatestCRL(tenantId, deltaCrl).getCRL().getEncoded();
    }

    public X509CRL getLatestX509Crl(int tenantId, boolean deltaCrl)
            throws CertificateException, CaException {
        return crlDataHolderDao.getLatestCRL(tenantId, deltaCrl).getCRL();
    }
}
