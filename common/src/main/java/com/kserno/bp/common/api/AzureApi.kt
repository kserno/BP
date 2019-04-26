package com.kserno.bp.common.api

import java.io.File

/**
 *  Created by filipsollar on 2019-04-26
 */
class AzureApi: Api {
    override fun synthesize(text: String): File {
        return File(text)
    }
}