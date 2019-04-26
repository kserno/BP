package com.kserno.bp.common.api

import java.io.File

/**
 *  Created by filipsollar on 2019-04-25
 */
interface Api {

    fun synthesize(text: String): File


}