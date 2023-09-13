import kotlin.wasm.WasmExport

@WasmExport(name= "_start")
fun main(){
    print("Hello")
}