export function notEmptyValidator(value) {
  return {
    valid: !(value == null || !String(value).length), // eslint-disable-line
    message: 'Value cannot be empty'
  };
}
