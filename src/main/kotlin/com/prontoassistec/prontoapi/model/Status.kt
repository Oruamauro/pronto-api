package com.prontoassistec.prontoapi.model

import io.swagger.annotations.ApiOperation

@ApiOperation(value = "Status de uma ordem de serviço.")
enum class Status {
            ABERTA,
            AGUARDANDO,
            SUSPENSA,
            FINALIZADA
}