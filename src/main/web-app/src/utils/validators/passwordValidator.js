export function passwordValidator(value) {
  return {
    valid: value.length >= 8,
    message: 'Invalid password format. Required format is at least 8 characters.'
  };
}

