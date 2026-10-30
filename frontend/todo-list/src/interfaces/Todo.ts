export type Prioridade = 'IMPORTANTE' | 'MEDIANA' | 'TRANQUILA'

export default interface Todo {

    id: number,
    titulo: string,
    descricao: string,
    prioridade: Prioridade,
    concluida: boolean
}