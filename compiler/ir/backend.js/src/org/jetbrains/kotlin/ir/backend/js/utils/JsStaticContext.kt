/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.utils

import org.jetbrains.kotlin.ir.backend.js.JsIrBackendContext
import org.jetbrains.kotlin.ir.backend.js.transformers.irToJs.JsIntrinsicTransformers
import org.jetbrains.kotlin.ir.expressions.IrLoop
import org.jetbrains.kotlin.ir.symbols.IrSymbol
import org.jetbrains.kotlin.ir.symbols.IrValueSymbol
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.js.backend.ast.JsClassModel
import org.jetbrains.kotlin.js.backend.ast.JsGlobalBlock
import org.jetbrains.kotlin.js.backend.ast.JsName
import org.jetbrains.kotlin.js.backend.ast.JsRootScope


class JsStaticContext(
    val rootScope: JsRootScope,
    private val globalBlock: JsGlobalBlock,
    private val nameGenerator: NameGenerator,
    backendContext: JsIrBackendContext
) {
    val intrinsics = JsIntrinsicTransformers(backendContext)
    // TODO: use IrSymbol instead of JsName
    val classModels = mutableMapOf<JsName, JsClassModel>()

    val initializerBlock = JsGlobalBlock()

    fun getNameForSymbol(irSymbol: IrSymbol, context: JsGenerationContext) = nameGenerator.getNameForSymbol(irSymbol, context)
    fun getNameForType(type: IrType, context: JsGenerationContext) = nameGenerator.getNameForType(type, context)
    fun getNameForReceiver(irSymbol: IrValueSymbol, isExt: Boolean, context: JsGenerationContext) = nameGenerator.getNameForReceiver(irSymbol, isExt, context)
    fun getNameForLoop(loop: IrLoop, context: JsGenerationContext) = nameGenerator.getNameForLoop(loop, context)
}