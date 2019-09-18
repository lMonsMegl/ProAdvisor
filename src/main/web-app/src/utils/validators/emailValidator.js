
export function emailValidator(string) {
   return {
    valid: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(string)
  }
}
